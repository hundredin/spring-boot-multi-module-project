/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package com.spring.core.config;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DefaultPhysicalNamingStrategy implements PhysicalNamingStrategy {
	private static final Map<String, String> ABBREVIATIONS = buildAbbreviationMap();

	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return name;
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return name;
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		final List<String> parts = splitAndReplace(name.getText());
		return jdbcEnvironment.getIdentifierHelper().toIdentifier(
				join(parts),
				name.isQuoted()
		);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		final LinkedList<String> parts = splitAndReplace(name.getText());
		return jdbcEnvironment.getIdentifierHelper().toIdentifier(
				join(parts),
				name.isQuoted()
		);

	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		final List<String> parts = splitAndReplace(name.getText());
		return jdbcEnvironment.getIdentifierHelper().toIdentifier(
				join(parts),
				name.isQuoted()
		);
	}

	private static Map<String, String> buildAbbreviationMap() {
		TreeMap<String, String> abbreviationMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		abbreviationMap.put("number", "num");
		return abbreviationMap;
	}

	private LinkedList<String> splitAndReplace(String name) {
		LinkedList<String> result = new LinkedList<>();
		for (String part : StringUtils.splitByCharacterTypeCamelCase(name)) {
			if (part == null || part.equals("_") || part.trim().isEmpty()) {
				// skip null and space
				continue;
			}
			part = applyAbbreviationReplacement(part);
			result.add(part.toLowerCase());
		}
		return result;
	}

	private String applyAbbreviationReplacement(String word) {
		if (ABBREVIATIONS.containsKey(word)) {
			return ABBREVIATIONS.get(word);
		}
		return word;
	}

	private String join(List<String> parts) {
		return parts.stream().collect(Collectors.joining("_"));
	}
}
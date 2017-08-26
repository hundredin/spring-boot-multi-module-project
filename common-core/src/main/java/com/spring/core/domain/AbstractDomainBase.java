package com.spring.core.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractDomainBase<U, PK extends Serializable> extends AbstractAuditable<U, PK> {

	private static final long serialVersionUID = 2041914571551811595L;

	@Version
	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override public String toString() {
		return new ToStringBuilder(this)
				.append("id", getId())
				.append("version", version)
				.append("createdDate", getCreatedDate())
				.append("createdBy_id", getCreatedBy())
				.append("lastModifiedDate", getLastModifiedDate())
				.append("lastModifiedBy_id", getLastModifiedBy())
				.toString();
	}
}

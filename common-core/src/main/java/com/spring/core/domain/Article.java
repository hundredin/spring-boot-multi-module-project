package com.spring.core.domain;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Configurable
public class Article extends AbstractDomainBase<Article, Long> {

	@Id
	@GeneratedValue
	Long id;

	@Column(nullable = false, length = 200)
	private String subject;

	@Column(nullable = false)
	private String content;

	@ManyToOne
	private User user;
}

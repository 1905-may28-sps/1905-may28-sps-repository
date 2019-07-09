# Hibernate Relationships
* one to one
* one to many
* many to many

[useful article](https://howtoprogramwithjava.com/hibernate-manytoone-unidirectional-tutorial/)

# JPA Annotations
* `@OneToOne`
* `@OneToMany`
* `@ManyToOne`
* `@ManyToMany`

# Example
* Unidirectional Mapping

```
@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@Column(name="d_id")
	private int id;

	@Column(name="d_name")
	private String name;

}  
```

```
@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="e_id")
	private int id;

	@Column(name="e_name")
	private String name;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dog")
	private Department department;

}
```

# Example
* Bidirectional Mapping

```
@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@Column(name="d_id")
	private int id;

	@Column(name="d_name")
	private String name;

  @OneToMany(mappedBy="department", fetch=FetchType.LAZY)
	private List<Employee> employees;

}  
```

```
@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="e_id")
	private int id;

	@Column(name="e_name")
	private String name;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dog")
	private Department department;

}
```

# Fetch Types
* **Lazy** - do not grab data until needed
* **Eager** - grab data immediately

# `LazyInitializationException`
* When you lazily fetch something
* Session closes
* Try to access what you lazily fetched

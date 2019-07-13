package com.revature.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

public class AccountInfo {
private int id;
private double balance;
private String authorfn;
private String authorln;
private String resolverfn;
private String resolverln;
private Timestamp submitted;
private Timestamp resolved;
private String description;
private Blob receipt;
private String rtype;
private String rstatus;
private int author;
private int resolver;

public AccountInfo() {}

public AccountInfo(int id, double balance, String resolverfn, String resolverln, Timestamp submitted, Timestamp resolved,
		String description, Blob receipt, String rtype, String rstatus, int author, int resolver) {
	super();
	this.id = id;
	this.balance = balance;
	this.resolverfn = resolverfn;
	this.resolverln = resolverln;
	this.submitted = submitted;
	this.resolved = resolved;
	this.description = description;
	this.receipt = receipt;
	this.rtype = rtype;
	this.rstatus = rstatus;
	this.author = author;
	this.resolver = resolver;
}

public AccountInfo(int id, double balance, String authorfn, String authorln, String resolverfn, String resolverln,
		Timestamp submitted, Timestamp resolved, String description, Blob receipt, String rtype, String rstatus,
		int author, int resolver) {
	super();
	this.id = id;
	this.balance = balance;
	this.authorfn = authorfn;
	this.authorln = authorln;
	this.resolverfn = resolverfn;
	this.resolverln = resolverln;
	this.submitted = submitted;
	this.resolved = resolved;
	this.description = description;
	this.receipt = receipt;
	this.rtype = rtype;
	this.rstatus = rstatus;
	this.author = author;
	this.resolver = resolver;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public String getAuthorfn() {
	return authorfn;
}

public void setAuthorfn(String authorfn) {
	this.authorfn = authorfn;
}

public String getAuthorln() {
	return authorln;
}

public void setAuthorln(String authorln) {
	this.authorln = authorln;
}

public String getResolverfn() {
	return resolverfn;
}

public void setResolverfn(String resolverfn) {
	this.resolverfn = resolverfn;
}

public String getResolverln() {
	return resolverln;
}

public void setResolverln(String resolverln) {
	this.resolverln = resolverln;
}

public Timestamp getSubmitted() {
	return submitted;
}

public void setSubmitted(Timestamp submitted) {
	this.submitted = submitted;
}

public Timestamp getResolved() {
	return resolved;
}

public void setResolved(Timestamp resolved) {
	this.resolved = resolved;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Blob getReceipt() {
	return receipt;
}

public void setReceipt(Blob receipt) {
	this.receipt = receipt;
}

public String getRtype() {
	return rtype;
}

public void setRtype(String rtype) {
	this.rtype = rtype;
}

public String getRstatus() {
	return rstatus;
}

public void setRstatus(String rstatus) {
	this.rstatus = rstatus;
}

public int getAuthor() {
	return author;
}

public void setAuthor(int author) {
	this.author = author;
}

public int getResolver() {
	return resolver;
}

public void setResolver(int resolver) {
	this.resolver = resolver;
}


}
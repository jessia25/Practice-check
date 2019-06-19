package com.pack.model;

public class Vendor {
private int stock,req,buffer,pending,vid;
public int getVid() {
	return vid;
}
public void setVid(int vid) {
	this.vid = vid;
}
public Vendor() {}
public Vendor(int stock, int req, int buffer, int pending) {
	super();
	this.stock = stock;
	this.req = req;
	this.buffer = buffer;
	this.pending = pending;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public int getReq() {
	return req;
}

public void setReq(int req) {
	this.req = req;
}

public int getBuffer() {
	return buffer;
}

public void setBuffer(int buffer) {
	this.buffer = buffer;
}

public int getPending() {
	return pending;
}

public void setPending(int pending) {
	this.pending = pending;
}
}

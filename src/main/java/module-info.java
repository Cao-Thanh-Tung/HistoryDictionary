module HistoryDictionary {
	exports backend.src.hust;
	exports frontend.view;
	exports frontend.jsonparse;
	exports backend.src.hust.model;
	exports backend;
	exports frontend.controller;
	exports frontend.model;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires json.simple;
	requires org.json;
	requires org.jsoup;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
}
module TestSystemProz
{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ormlite.core;
    requires ormlite.jdbc;

    opens proz;
    opens proz.controllers;
    opens fxmlFiles;
    opens proz.utils;
    opens proz.models;
}
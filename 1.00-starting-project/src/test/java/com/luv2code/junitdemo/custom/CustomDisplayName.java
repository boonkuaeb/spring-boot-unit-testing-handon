package com.luv2code.junitdemo.custom;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class CustomDisplayName {

    public static class ReplaceCamelCase extends DisplayNameGenerator.Standard {
        public ReplaceCamelCase() {
        }

        public String generateDisplayNameForClass(Class<?> testClass) {
            return this.replaceCapitals(super.generateDisplayNameForClass(testClass));
        }

        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return this.replaceCapitals(super.generateDisplayNameForNestedClass(nestedClass));
        }

        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return this.replaceCapitals(testMethod.getName());
        }

        private String replaceCapitals(String name) {
            name = name.replaceAll("([A-Z])", " $1");
            name = name.replaceAll("([0-9]+)", " $1");
            return name;
        }
    }
    public static class ReplaceCamelCaseEmojis extends ReplaceCamelCase {
        public ReplaceCamelCaseEmojis() {
        }

        public String generateDisplayNameForClass(Class<?> testClass) {
            return this.replaceWithEmojis(super.generateDisplayNameForClass(testClass));
        }

        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return this.replaceWithEmojis(super.generateDisplayNameForNestedClass(nestedClass));
        }

        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return this.replaceWithEmojis(super.generateDisplayNameForMethod(testClass, testMethod));
        }

        private String replaceWithEmojis(String name) {
            name = name.replaceAll("Camel|camel", "\uD83D\uDC2B");
            name = name.replaceAll("Case|case", "\uD83D\uDCBC");
            name = name.replaceAll("Display|display", "\uD83D\uDCBB");
            name = name.replaceAll("Divisible|divisible", "\u2797");
            name = name.replaceAll("Year|year", "\uD83D\uDCC5");
            name = name.replaceAll("100", "\uD83D\uDCAF");
            return name;
        }
    }
}
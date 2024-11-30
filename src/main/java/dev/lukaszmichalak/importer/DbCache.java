package dev.lukaszmichalak.importer;

import java.util.Map;

record DbCache(Map<String, Integer> voivodeshipMap, Map<String, Integer> productTypeMap) {}

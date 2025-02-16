package dev.lukaszmichalak.importer;

import java.util.Map;

record DbCache(Map<String, Long> voivodeshipMap, Map<String, Long> productTypeMap) {}

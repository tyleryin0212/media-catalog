package com.tyleryin.medialibrary.service;

import com.tyleryin.medialibrary.in_memory_domain.Creator;

public record ItemPatch(String title, Integer year, Creator creator) {
}

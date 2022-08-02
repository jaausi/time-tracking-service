package com.sirvja.timetrackingservice.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Title(@Id String id, @NonNull String name, String description) {
}

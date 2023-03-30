package com.york.course.json;

import com.google.gson.JsonObject;

import java.util.Objects;

public class JsonResponse {

    private JsonObject message;

    public JsonObject getMessage() {
        return message;
    }

    public void setMessage(JsonObject message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponse that = (JsonResponse) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "message=" + message +
                '}';
    }
}

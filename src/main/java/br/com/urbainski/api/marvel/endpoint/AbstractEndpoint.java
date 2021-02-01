package br.com.urbainski.api.marvel.endpoint;

import org.springframework.http.ResponseEntity;

public abstract class AbstractEndpoint {

    public ResponseEntity<Object> ok(Object o) {

        return ResponseEntity.ok(o);
    }

    public ResponseEntity<Object> noContent() {

        return ResponseEntity.noContent().build();
    }

}
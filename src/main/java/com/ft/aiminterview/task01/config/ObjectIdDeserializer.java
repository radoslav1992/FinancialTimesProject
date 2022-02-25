package com.ft.aiminterview.task01.config;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import org.bson.types.ObjectId;

import java.io.IOException;

public class ObjectIdDeserializer extends FromStringDeserializer<ObjectId> {

    public ObjectIdDeserializer() {
        super(ObjectId.class);
    }

    @Override
    protected ObjectId _deserialize(final String value, final DeserializationContext ctxt) throws IOException {
        return new ObjectId(value);
    }
}

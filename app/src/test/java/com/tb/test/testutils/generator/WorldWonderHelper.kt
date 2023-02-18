package com.tb.test.testutils.generator

import com.tb.test.data.entity.WorldWonderEntity
import com.tb.test.domain.model.WorldWonder
import com.tb.test.ui.list.viewholder.WorldWonderViewHolder

fun newWorldWonderEntity(id: Long): WorldWonderEntity {
    val text = "test$id"
    return WorldWonderEntity(
        id,
        0,
        text,
        text,
        text,
        text,
        text,
        text,
        0.0,
        0.0,
        text,
        text,
        text,
        text,
        text
    )
}

fun newWorldWonder(id: Long): WorldWonder {
    val text = "test$id"
    return WorldWonder(id, text, text, text, text)
}

fun newContent(id: Long): WorldWonderViewHolder.Content {
    val text = "test$id"
    return WorldWonderViewHolder.Content(id, text, text, text, text) {}
}
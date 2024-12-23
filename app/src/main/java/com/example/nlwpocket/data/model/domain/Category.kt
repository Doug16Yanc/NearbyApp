package com.example.nlwpocket.data.model.domain

import androidx.annotation.DrawableRes
import com.example.nlwpocket.ui.component.category.CategoryFilterChipView

data class Category(
    val id : String,
    val name : String
) {@get:DrawableRes
    val icon : Int?
        get() = CategoryFilterChipView.fromDescription(description = name)?.icon
}
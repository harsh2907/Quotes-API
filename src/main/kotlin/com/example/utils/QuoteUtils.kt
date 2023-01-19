package com.example.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.http.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


object QuoteUtils {

    val quotes: List<Quote> = try {
        val quotesJson = File("D:\\Backend Ktor\\quote-api\\src\\main\\kotlin\\com\\example\\utils\\Quotes.json").readText()

        Gson().fromJson(quotesJson, object : TypeToken<ArrayList<Quote>>() {}.type)

    } catch (e: FileNotFoundException) {
        println(e.message)
        println("File not found")
        emptyList()
    } catch (e: IOException) {
        println("Error reading file")
        emptyList()
    }


}
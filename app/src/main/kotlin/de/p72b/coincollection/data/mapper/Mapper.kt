package de.p72b.coincollection.data.mapper

interface Mapper<INPUT, OUTPUT> {
    fun map(input: INPUT): OUTPUT
}
import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readInput(inputName: String) = File("inputs/$inputName").readLines()


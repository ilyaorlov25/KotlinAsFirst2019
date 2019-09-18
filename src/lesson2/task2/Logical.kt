@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val dig1 = number / 1000
    val dig2 = (number / 100) % 10
    val dig3 = (number / 10) % 10
    val dig4 = number % 10

    return (dig1 + dig2 == dig3 + dig4)
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val vertOrHor = (x1 == x2 || y1 == y2) //Проверяем, угрожают ли по вертикали либо по горизонтали
    val diag = abs(x1 - x2) == abs(y1 - y2) // Проверяем, угрожают ли по диагонали

    return (diag || vertOrHor)
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    var isLeap = false
    if (year % 4 == 0) isLeap = !(year % 100 == 0 && year % 400 != 0)

    return when {
        month == 2 && isLeap -> 29
        month == 2 && !isLeap -> 28
        (month == 4) || (month == 6) || (month == 9) || (month == 11) -> 30
        else -> 31
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    //Находим координаты крайних точек 1-й окружности
    val left1 = x1 - r1
    val right1 = x1 + r1
    val up1 = y1 + r1
    val down1 = y1 - r1
    //Находим расстояние от крайних точек 1-й окружности до центра 2-й
    val distLeft = sqrt(sqr(left1 - x2) + sqr(y1 - y2))
    val distRight = sqrt(sqr(right1 - x2) + sqr(y1 - y2))
    val distUp = sqrt(sqr(x1 - x2) + sqr(up1 - y2))
    val distDown = sqrt(sqr(x1 - x2) + sqr(down1 - y2))
    //Сравниваем полученное расстояние с радиусом 2-й окружности
    return distDown <= r2 && distLeft <= r2 && distRight <= r2 && distUp <= r2
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    return when {
        (a <= r) && (b <= s || c <= s) -> true
        (b <= r) && (a <= s || c <= s) -> true
        (c <= r) && (a <= s || b <= s) -> true
        else -> false
    }
}

@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.math.max
import kotlin.math.min
import kotlin.math.abs

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var sum = 0
    var num = n
    do {
        num /= 10
        sum += 1
    } while (num != 0)
    return sum
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fibFirst = 1
    var fibSecond = 1
    var fibThird = 1
    for (i in 3..n) {
        fibThird = fibFirst + fibSecond
        fibFirst = fibSecond
        fibSecond = fibThird
    }
    return fibThird
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..(n / 2))
        if (n % i == 0) {
            return i
        }
    return n
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    val num = n - 1
    for (i in num downTo 1)
        if (n % i == 0) {
            return i
        }
    return 2

}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var sum = 0
    var num = x
    while (num != 1) {
        if (num % 2 == 0) {
            num /= 2
        } else {
            num = 3 * num + 1
        }
        sum += 1
    }
    return sum
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var numFirst = m
    var numSecond = n
    while (numFirst != numSecond)
        if (numFirst > numSecond)
            numFirst -= numSecond
        else numSecond -= numFirst
    return n * m / numSecond
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var numFirst = m
    var numSecond = n
    while (numFirst != 0 && numSecond != 0) {
        if (numFirst > numSecond) numFirst %= numSecond
        else numSecond %= numFirst
    }
    return numFirst + numSecond == 1
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var reversionNumb = 0
    var numb = n
    while (numb >= 1) {
        val dig = (numb % 10)
        reversionNumb = reversionNumb * 10 + dig
        numb /= 10
    }
    return reversionNumb
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var reversionNumb = 0
    var numb = n
    var dig: Int
    while (numb > 0) {
        dig = (numb % 10)
        reversionNumb = reversionNumb * 10 + dig
        numb /= 10
    }
    return (n == reversionNumb)
}

fun isPalindrome(n: Int): Boolean {
    var number1 = n
    var flag = true
    var divider = 1
    if (n < 10) return true
    else {
        for (i in 1 until digitNumbers(n)) divider *= 10
        while (number1 > 0) {
            if (number1 % 10 != number1 / divider) {
                flag = false
                break
            }
            number1 %= divider
            number1 /= 10
            divider /= 100
        }
        return flag
    }
}
/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var number: Int
    var number1: Int
    var divider = 1
    var flag = false
    if (n < 10) return false
    else {
        number = n
        for (i in 1 until digitNumbers(n)) divider *= 10
        while (number > 0) {
            number1 = number
            while (number1 > 0) {
                if ((number1 % 10) != (number % 10)) flag = true
                number1 /= 10
            }
            number /= 10
        }
        return flag
    }
}


fun exponentiation(n: Int, x: Int): Int {
    var x1 = 1.0
    for (i in 1..n) x1 *= x
    return x1.toInt()
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */

fun sin(x: Double, eps: Double): Double = TODO()


/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var number = 0
    var sequenceToNumberOrDigit = 0
    var lengthToNumberOrDigit = 0
    while (lengthToNumberOrDigit < n) {
        number++
        sequenceToNumberOrDigit = number * number
        lengthToNumberOrDigit += digitNumber(sequenceToNumberOrDigit) // функция из задачи выше
    }
    while (n < lengthToNumberOrDigit) {
        lengthToNumberOrDigit--
        sequenceToNumberOrDigit /= 10
    }
    return sequenceToNumberOrDigit % 10
}

fun sequenceDigit(n: Int, f: Int): Int {
    var count = 1
    var number: Int = if (f == 0) n
    else f
    var x = 1
    var x2: Int
    while (true) {
        if (f == 0) {
            x = count * count
        }
        if (n == 0) {
            x = fib(count)
        }
        x2 = x
        var numberOfDigits = 0
        while (x2 > 0) {
            numberOfDigits++
            x2 /= 10
        }
        if (number - numberOfDigits > 0) {
            number -= numberOfDigits
            count += 1
        } else if (number - numberOfDigits == 0) {
            var m = x % 10
            count += 1
            return m
        } else {
            count += 1
            return (x / exponentiation(abs(number - numberOfDigits), 10)) % 10
        }
    }
}


fun squareSequenceDigit(n: Int): Int = sequenceDigit(n, 0)
/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var number = 0
    var sequenceToNumberOrDigit = 0
    var lengthToNumberOrDigit = 0
    while (lengthToNumberOrDigit < n) {
        number++
        sequenceToNumberOrDigit = fib(number) // функция из задачи выше
        lengthToNumberOrDigit += digitNumber(sequenceToNumberOrDigit)
    }
    while (n < lengthToNumberOrDigit) {
        lengthToNumberOrDigit--
        sequenceToNumberOrDigit /= 10
    }
    return sequenceToNumberOrDigit % 10
}


fun main() {
    check(clumsy(0) == 0) { "clumsy(0) should be 0" }
    check(clumsy(1) == 1) { "clumsy(1) should be 1" }
    check(clumsy(2) == 2) { "clumsy(2) should be 2" }
    check(clumsy(3) == 6) { "clumsy(3) should be 6" }
    check(clumsy(4) == 7) { "clumsy(4) should be 7" }
    check(clumsy(10) == 12) { "clumsy(10) should be 12" }
    println("All tests passed!")
}

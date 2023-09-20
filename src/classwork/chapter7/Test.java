package classwork.chapter7;

// Objects may be passed to methods
class Test {
    int a, b;

    Test(int i, int j) {
        a = i;
        b = j;
    }

    Test(int i) {
        a = i;
    }

    Test() {
    }

    // return true if o is equal to the invoking object
    boolean equalTo(Test o) {
        if (o.a == a && o.b == b) {
            return true;
        }
        return false;
    }

    void meth(int i, int j) {
        i *= 2;
        j /= 2;
    }

    void meth(Test o) {
        o.a *= 2;
        o.b /= 2;
    }

    Test incrByTen() {
        Test tmp = new Test(a + 10);
        return tmp;
    }
}

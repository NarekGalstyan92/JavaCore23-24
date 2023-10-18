package classwork.chapter9;

// B implements the nested interface
class B implements A.NestedIf {
    @Override
    public boolean isNotNegative(int x) {
        return x < 0 ? false : true;
    }
}

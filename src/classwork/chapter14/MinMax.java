package classwork.chapter14;

// A generic interface example
// A Min/Max interface
interface MinMax <T extends  Comparable<T>>{
    T min();
    T max();
}

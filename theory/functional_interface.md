# ⚙️ Functional Interfaces trong Java

## I. Functional Interface là gì?

> **Functional Interface** là interface có **duy nhất một abstract method**, đại diện cho **một “hàm”** (function type).  
> Dùng để gắn với **lambda expression** hoặc **method reference**.

📘 **Ví dụ:**
```java
@FunctionalInterface
public interface MyFunc {
    int apply(int a, int b);
}

MyFunc add = (a, b) -> a + b;
System.out.println(add.apply(3, 4)); // 7
```

## II. Các Functional Interface chuẩn trong java.util.function

Java cung cấp nhiều interface sẵn có, chia nhóm theo mục đích.
Dưới đây là 4 loại cơ bản và phổ biến nhất. 

   ### `1️⃣ Predicate<T>`

- Mục đích: Đại diện cho hàm boolean test — nhận 1 đầu vào, trả về true/false.

- Khai báo:
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

- Ví dụ:
```java
Predicate<Integer> isEven = n -> n % 2 == 0;

System.out.println(isEven.test(10)); // true
System.out.println(isEven.test(3));  // false

// combine with stream()
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
numbers.stream()
       .filter(isEven)
       .forEach(System.out::println); // 2, 4
```
- Ứng dụng: Lọc dữ liệu, kiểm tra điều kiện, validation

### `2️⃣ Function<T, R>`

- Mục đích: Hàm có đầu vào → đầu ra (mapping function).

- Khai báo:
```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

- Ví dụ:
```java
Function<String, Integer> len = s -> s.length();
System.out.println(len.apply("Java")); // 4

// combine with stream()
List<String> names = List.of("Tom", "Jerry", "Anna");
names.stream()
     .map(len)
     .forEach(System.out::println); // 3, 5, 4
```
- Ứng dụng: Mapping, xử lý dữ liệu, chuyển đổi kiểu.

### `3️⃣ Consumer<T>`
- Mục đích: Hàm tiêu thụ (consume) — nhận đầu vào, không trả về gì.

- Khai báo:
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

- Ví dụ:
```java
Consumer<String> print = s -> System.out.println("Hello " + s);
print.accept("Java"); // Hello Java

List<String> list = List.of("A", "B", "C");
list.forEach(print); // Hello A, Hello B, Hello C
```
-  Ứng dụng: Logging, hiển thị UI, side-effect.

### `4️⃣ Supplier<T>`
Mục đích: Cung cấp dữ liệu — không có đầu vào, chỉ trả về giá trị.

Khai báo:
```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

- Ví dụ: 
```java
Supplier<Double> random = () -> Math.random();
System.out.println(random.get()); // 0.7324

Supplier<List<String>> getDefaultList = () -> List.of("N/A", "None");
System.out.println(getDefaultList.get());
```

- Ứng dụng: Sinh dữ liệu, caching, factory pattern.

## III. Một số các Functional Interface hay dùng khác 
## 🧩 III. Các Functional Interface hay dùng khác

Ngoài 4 loại cơ bản (`Predicate`, `Function`, `Consumer`, `Supplier`),  
Java còn cung cấp nhiều **functional interface mở rộng** trong package `java.util.function`,  
giúp xử lý các trường hợp nhiều tham số hoặc thao tác đặc biệt hơn.

| Interface | Đặc điểm | Ví dụ | Mô tả ngắn |
|------------|-----------|-------|-------------|
| `BiFunction<T, U, R>` | Nhận **2 đầu vào** → trả về **1 kết quả** | `(a, b) -> a + b` | Dùng khi cần kết hợp 2 giá trị thành 1 (ví dụ: cộng, nối chuỗi, hợp object) |
| `BinaryOperator<T>` | Giống `BiFunction<T,T,T>` (đầu vào & đầu ra cùng kiểu) | `(x, y) -> x * y` | Dùng cho phép toán gộp cùng kiểu (max, sum, multiply) |
| `UnaryOperator<T>` | Giống `Function<T,T>` | `x -> x.toUpperCase()` | Dùng khi đầu vào & đầu ra cùng kiểu (ví dụ: xử lý chuỗi) |
| `BiPredicate<T, U>` | Nhận **2 đầu vào** → trả về `boolean` | `(x, y) -> x > y` | So sánh, kiểm tra điều kiện giữa 2 giá trị |
| `BiConsumer<T, U>` | Nhận **2 đầu vào**, **không trả về gì** | `(key, val) -> System.out.println(key + ":" + val)` | Dùng trong `Map.forEach()`, logging hoặc xử lý cặp dữ liệu |

> 🔹 Những interface này cực kỳ phổ biến trong **Stream API**, **Collections** và **Functional Programming** trong Java hiện đại.

---

## 💡 IV. Lợi ích khi dùng Functional Interface

Functional Interface mang lại **sức mạnh lập trình hàm** cho Java — giúp code ngắn gọn, dễ đọc, dễ tái sử dụng, và thân thiện với Stream API.

| 💎 Lợi ích | 💬 Giải thích | 🧠 Ví dụ |
|-------------|----------------|----------|
| **Ngắn gọn** | Thay vì class ẩn danh dài dòng | `(x) -> x + 1` thay cho `new Function<Integer, Integer>() {...}` |
| **Dễ đọc & bảo trì** | Diễn tả ý đồ “filter”, “map” rõ ràng, dễ hiểu | `list.stream().filter(isEven).map(len)` |
| **Tái sử dụng & kết hợp** | Có thể kết hợp nhiều hàm (`andThen`, `compose`, `negate`) | `Function<String, Integer> lenAndSquare = len.andThen(x -> x * x)` |
| **Tận dụng Stream API** | Là nền tảng cho `map()`, `filter()`, `forEach()` | Xử lý danh sách ngắn gọn, thay cho vòng lặp thủ công |
| **Tương thích với Lambda & Method Reference** | Viết code hiện đại, gọn, dễ đọc | `System.out::println` là `Consumer<String>` |

> ✅ Functional Interfaces giúp Java **hướng tới phong cách lập trình hàm (Functional Programming)** mà vẫn **giữ được tính an toàn kiểu (type safety)** đặc trưng của ngôn ngữ hướng đối tượng.

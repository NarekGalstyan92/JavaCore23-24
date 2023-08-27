package classwork.chapter3;

 class StrExample {
     public static void main(String[] args) {
//         char [] name = {'p', 'o', 'x', 'o', 's'};
//         for (int i = 0; i < name.length; i++) {
//             System.out.print(name[i]);
//         }

         String name = "Poxos";
//         System.out.println(name);
//         char[] chars = name.toCharArray();
//         for (int i = 0; i < chars.length; i++) {
//             System.out.print(chars[i]);
//         }
         for (int i = 0; i < name.length(); i++) {
             System.out.println(name.charAt(i));
         }
     }
}

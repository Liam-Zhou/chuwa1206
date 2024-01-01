package Coding.Synchronized;


class SynchronizedThread {

        public static void main(String[] args) throws InterruptedException {
            Thread[] ts = new Thread[]{
                    new AddStudentThread(),
                    new DecStudentThread(),
                    new AddTeacherThread(),
                    new DecTeacherThread()
            };
            for (Thread t : ts) {
                t.start();
            }

            for (Thread t : ts) {
                t.join();
            }

            System.out.println(Counter.studentCount);
            System.out.println(Counter.teacherCount);
        }


    /**
     * Locker
     */
  static   class Counter {
        public static final Object LOCK_STUDENT = new Object();
        public static final Object LOCK_TEACHER = new Object();
        public static int studentCount = 0;
        public static int teacherCount = 0;
    }

  static   class AddStudentThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (Counter.LOCK_STUDENT) {
                    System.out.println("Executed t4");
                    Counter.studentCount += 1;
                }
            }
        }
    }

 static   class DecStudentThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (Counter.LOCK_STUDENT) {
                    System.out.println("Executed t1");
                    Counter.studentCount -= 1;
                }
            }
        }
    }

  static class AddTeacherThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (Counter.LOCK_STUDENT) {
                    System.out.println("Executed t2");
                    Counter.teacherCount += 1;
                }
            }
        }
    }

  static   class DecTeacherThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (Counter.LOCK_STUDENT) {
                    System.out.println("Executed t3");
                    Counter.teacherCount -= 1;
                }
            }
        }
    }

}
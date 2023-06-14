class ThreadEjemplo2 implements Runnable {
    public void run() {
        for (int i = 0; i < 20 ; i++) 
            System.out.println(i + " soy " + Thread.currentThread().getName());
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }    
}
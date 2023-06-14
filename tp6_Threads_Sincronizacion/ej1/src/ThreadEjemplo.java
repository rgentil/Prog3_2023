class ThreadEjemplo extends Thread {
	//Constructor sin asignarle nombre
    public ThreadEjemplo() {
        super();
    }
    
    //Constructor asignando un nombre s al thread
    public ThreadEjemplo(String	s) {
        super(s);
    }
    
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(i + " soy " + getName());
        }
        System.out.println("Termina thread " + getName());
    }
}


































/*     try {
sleep((int) (700*Math.random()));
} catch (InterruptedException e)
{}
*/
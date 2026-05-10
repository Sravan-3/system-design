class CpuWork {

    public int execute(int a, int b, char op) {
        switch (op) {
            case '+': return add(a, b);
            case '-': return sub(a, b);
            case '*': return mul(a, b);
            case '/': return div(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private int add(int a, int b){
        return a+b;
    }

    private int sub(int a, int b){
        return a-b;
    }

    private int mul(int a, int b){
        return a*b;
    }

    private int div(int a, int b){
        return a/b;
    }
}

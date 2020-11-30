class ArrayStack<E> implements Stack<E> {
  protected int capacity;
  public static final int CAPACITY = 1000000;
  protected E S[];
  protected int top = -1;

  public ArrayStack(){
    this(CAPACITY);
  }

  public ArrayStack(int cap){
    capacity = cap;
    S = (E[]) new Object[capacity];
  }

  public int size(){ return top + 1; }

  public boolean isEmpty(){ return top < 0; }

  public E top() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    return S[top];
  }

  public void push(E element) throws FullStackException {
    if(size() == capacity) throw new FullStackException("A pilha está cheia");
    S[++top] = element; // primeiro atualiza top e depois coloca no arranjo
  }

  public E pop() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    E element = S[top];
    S[top--] = null; // primeiro atualiza o arranjo e depois o top
    return element;
  }
}

public class StringContainer implements Container<String>{

    private String[] names = {"Alice", "Bob", "Charlie"};

    @Override
    public Iterator<String> getInterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {
        
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            return names[index++];
        }
    
        
    }
}

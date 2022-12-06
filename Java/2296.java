class TextEditor {

    private Item head;
    private Item tail;
    private Item cur;

    public TextEditor() {
        head = new Item();
        tail = new Item();
        cur = head;
        tail.prev = head;
        head.next = tail;
    }

    public void addText(String text) {
        for (char ch : text.toCharArray()){
            Item item = new Item(ch);
            item.prev = cur;
            item.next = cur.next;
            cur.next.prev = item;
            cur.next = item;
            cur = cur.next;
        }
    }

    public int deleteText(int k) {
        int sz = k;
        while(--k >= 0 && cur != head){
            Item next = cur.prev;
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
            cur = next;
        }
        return sz - k - 1;
    }

    public String cursorLeft(int k) {
        while(--k >= 0 && cur != head){
            cur = cur.prev;
        }
        return getText(cur);
    }

    public String cursorRight(int k) {
        while(--k >= 0 && cur.next != tail){
            cur = cur.next;
        }
        return getText(cur);
    }

    private String getText(Item st){
        int k = 10;
        StringBuilder sb = new StringBuilder();
        while(--k >= 0 && st != head){
            sb.append(st.ch);
            st = st.prev;
        }
        return sb.reverse().toString();
    }

    private class Item {
        char ch;
        Item next;
        Item prev;
        Item (){}
        Item (char ch){
            this.ch = ch;
        }
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */

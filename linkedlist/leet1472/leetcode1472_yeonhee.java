package linked_list;

// 127 ms, 81.9mb
class BrowserHistory {
    HomePage head;
    HomePage tail;
    class HomePage{
        HomePage prev;
        HomePage next;
        String url;
        HomePage(String url)
        {
            this.prev = null;
            this.next = null;
            this.url = url;
        }
    }

    public BrowserHistory(String homepage) {
        if(this.head == null)
        {
            this.head = new HomePage(homepage);
            this.tail = this.head;
        }
    }

    public void visit(String url) {
        HomePage tmp = this.head;
        
        // 현재 홈페이지의 다음 페이지를 끊어낸다
        // 현재 헤드포인터는 현재 페이지를 가리키고 있음
        this.head.next = null;
        while(tmp.next != null)
        {
            tmp = tmp.next;
        }
        HomePage newPage    = new HomePage(url);
        tmp.next            = newPage;
        newPage.prev        = tmp;
        newPage.next        = null;
        this.head           = newPage;
    }

    public String forward(int steps) {
        HomePage tmp = this.head;
        int tmpSteps = 0;
        while(tmp.next != null && tmpSteps < steps)
        {
            tmp = tmp.next;
            tmpSteps++;
        }
        this.head = tmp;
        return tmp.url;
    }

    public String back(int steps) {
        HomePage tmp = this.head;
        int tmpSteps = 0;
        while(tmp.prev != null && tmpSteps < steps)
        {
            tmp = tmp.prev;
            tmpSteps++;
        }
        this.head = tmp;
        return tmp.url;
    }

    public void ShowAll(){
        HomePage tmp = this.head;
        System.out.println(tmp.url);
        while(tmp.next != null)
        {
            tmp = tmp.next;
            System.out.println(tmp.url);
        }
    }

    public void ShowCurrentPage() {
        System.out.println("======================");
        if(this.head != null)
            System.out.println(this.head.url);
        System.out.println("======================");
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

public class leetcode_1472 {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");                           // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

    }
}

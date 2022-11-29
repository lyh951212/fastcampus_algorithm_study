/**
* Runtime : 54 ms
* Memory : 50 MB
*/
class BrowserHistory {

    LinkedList<String> list = new LinkedList<>();
    int currentPage; // 현재 페이지 위치
    int forward; // 앞쪽으로 이동할 수 있는 페이지 수
    
    public BrowserHistory(String homepage) {
        list.add(homepage);
        currentPage = 0;
        forward = 0;
    }
    
    public void visit(String url) {
        list.add(++currentPage, url); // 리스트에 방문한 페이지 삽입
        forward = currentPage; // 방문한 페이지까지 앞쪽으로 이동 가능
    }
    
    public String back(int steps) {
        // steps 만큼 이동할 페이지가 없다면 맨 뒷 페이지로 이동
        if(steps > currentPage) { 
            currentPage = 0; 
            return list.get(currentPage);
        }
        // 뒤로 이동할 수 있다면 현재 페이지에서 steps 만큼 뒤로 이동
        currentPage -= steps; 
        return list.get(currentPage);
    }
    
    public String forward(int steps) {
        // 현재 페이지에서 앞 쪽으로 이동할 수 없다면 forward 위치까지만 이동
        if(steps+currentPage > forward) { 
            currentPage = forward;
            return list.get(forward);
        }
        
        // 이동할 수 있다면 steps 만큼 앞으로 이동
        currentPage += steps;
        return list.get(currentPage);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

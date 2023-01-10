class Solution(object):
    def maxArea(self, height):
        answer = 0
        # 초기 값으로 처음과 끝 인덱스
        front, back = 0, len(height)-1

        while front < back :
            # 물의 양을 계산하기 위한 높이(두 막대기 중 가장 작은 값)
            min_height = min(height[front], height[back])
            # 물의 양을 계산하기 위한 너비(두 막대기 인덱스를 뺀 값) 
            width = abs(front - back)

            # 물의 양 계산하여 최댓값 갱신
            answer = max(answer, min_height * width)

            # 뒤에 있는 막대기 높이가 크다면 front를 변경 
            if height[front] < height[back]:
                front += 1
            elif height[front] == height[back]:
                if abs(0-front) < abs(len(height)-back):
                    front += 1
                else:
                    back -= 1
            # 앞에 있는 막대기 높이가 크다면 back을 변경
            else:
                back -= 1
        
        return answer
        
# Runtime : 590 ms , Memory : 24.1 MB

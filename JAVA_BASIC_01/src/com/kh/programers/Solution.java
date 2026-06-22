package com.kh.programers;

class Solution {
    public int[][] solution(int n) {
    	int[][] answer = new int[n][n];
    	
    	if(n==1) {
    		answer[0][0] = 1;
    		return answer;
        }
    	if(n==2) {
    		answer[0][0] = 1;
    		answer[0][1] = 2;
    		answer[1][1] = 3;
    		answer[1][0] = 4;
    		return answer;
    	}
 
    	char mode = 'd';
    	int x=1, y=1, cnt=1;
    	
    	for(int i=0; i<answer[0].length; i++) {
    		answer[0][i] = cnt++;
    	}
    	for(int i=1; i<answer.length; i++) {
    		answer[i][answer.length-1] = cnt++;
    	}
    	for(int i=answer.length-2; i>=0; i--) {
    		answer[answer.length-1][i] = cnt++;
    	}
    	for(int i=answer.length-2; i>0; i--) {
    		answer[i][0] = cnt++;
    	}
    	
    	
    	
    	while(mode != 'e') {
    		answer[y][x] = cnt++;
    		switch(mode) {
    		case 'w':
    			if(answer[y-1][x] == 0) {
    				y--;
    			}
    			else if(answer[y][x+1] == 0) {
    				x++;
    				mode = 'd';
    			}
    			else {
    				mode = 'e';
    			}
    			break;

    		case 'a':
    			if(answer[y][x-1] == 0) {
    				x--;
    			}
    			else if(answer[y-1][x] == 0) {
    				y--;
    				mode = 'w';
    			}
    			else {
    				mode = 'e';
    			}
    			break;

    		case 's':
    			if(answer[y+1][x] == 0) {
    				y++;
    			}
    			else if(answer[y][x-1] == 0) {
    				x--;
    				mode = 'a';
    			}
    			else {
    				mode = 'e';
    			}
    			break;

    		case 'd':
    			if(answer[y][x+1] == 0) {
    				x++;
    			}
    			else if(answer[y+1][x] == 0) {
    				y++;
    				mode = 's';
    			}
    			else {
    				mode = 'e';
    			}
    			break;
    			
    		default:
    			break;
    		}
    	}
        
        return answer;
    }
}

/*
 * 1 2 3 4
 * 12 13 0 5
 * 11 14 15 6
 * 10 9 8 7
 */



// A: 65 Z: 90 a: 97 z:122






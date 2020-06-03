package com.a5.group18.enumerated;

public enum Grades {
    A_PLUS, A, A_MINUS, B_PLUS, B, B_MINUS, C_PLUS, C, C_MINUS, D_PLUS, D, D_MINUS;

    public int compareGrade() {
        if (!(this.equals(A_PLUS) || this.equals(A) || this.equals(A_MINUS) || this.equals(B_PLUS) || this.equals(B) || this.equals(B_MINUS) ||
                this.equals(C_PLUS) || this.equals(C) || this.equals(C_MINUS))){
            return -1;
        }
        else
            return 1;
        
    }
}

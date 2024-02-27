package com.dynatrace.secret;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyMethodVisitor extends MethodVisitor {
    private Label start;
    private Label end;

    private int startLabelineNumber = 11;
    private int endLabelLineNumber = 14;

    public MyMethodVisitor(MethodVisitor methodVisitor, String className, String methodName, String methodToVisit) {
        super(Opcodes.ASM4, methodVisitor);
    }

    @Override
    public void visitCode() {
        super.visitCode();
    }

    @Override
    public void visitLineNumber(int line, Label label) {

        super.visitLineNumber(line, label);

        if (line == startLabelineNumber) {
            this.start = label;
        }

        if (line == endLabelLineNumber) {
            this.end = label;
        }

        // Add code to visit each line of the method
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        // Add code to visit the end of the method
    }

    @Override
    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        super.visitLocalVariable(name, descriptor, signature, this.start, end, index);
    }
}

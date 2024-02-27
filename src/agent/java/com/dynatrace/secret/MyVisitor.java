package com.dynatrace.secret;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyVisitor extends ClassVisitor {
    private String className;
    private String methodName;

    public MyVisitor(ClassVisitor classVisitor, String className, String methodName) {
        super(Opcodes.ASM4, classVisitor);
        this.className = className;
        this.methodName = methodName;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        if (name.equals("addTwo")) {
            return new MyMethodVisitor(super.visitMethod(access, name, desc, signature, exceptions), className, name, methodName);
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }


}

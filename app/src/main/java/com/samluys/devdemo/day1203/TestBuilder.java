package com.samluys.devdemo.day1203;

/**
 * @author luys
 * @describe
 * @date 2018/12/3
 * @email samluys@foxmail.com
 */
public class TestBuilder {
    private final int id;
    private final String name;

    private final int age;
    private final int sex;
    private final int height;
    private final int wegit;
    private final String remarkName;



    private TestBuilder(Builder1 builder) {
        this.id = builder.id;
        this.age = builder.age;
        this.name = builder.name;
        this.sex = builder.sex;
        this.height = builder.height;
        this.wegit = builder.weight;
        this.remarkName = builder.remarkName;
    }

    private TestBuilder(Builder2 builder) {
        this.id = builder.id;
        this.age = builder.age;
        this.name = builder.name;
        this.sex = builder.sex;
        this.height = builder.height;
        this.wegit = builder.weight;
        this.remarkName = builder.remarkName;
    }

    public static class Builder1 implements Builder<TestBuilder>{
        private final int id;
        private final String name;

        private int age;
        private int sex;
        private int height;
        private int weight;
        private String remarkName;

        public Builder1(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder1 setAge(int val) {
            this.age = val;
            return this;
        }

        public Builder1 setSex(int val) {
            this.sex = val;
            return this;
        }

        public Builder1 setHeight(int val) {
            this.height = val;
            return this;
        }

        public Builder1 setWeight(int val) {
            this.weight= val;
            return this;
        }

        public Builder1 setRemarkName(String val) {
            this.remarkName = val;
            return this;
        }

        @Override
        public TestBuilder build() {
            return new TestBuilder(this);
        }
    }

    public static class Builder2 implements Builder<TestBuilder>{
        private final int id;
        private final String name;

        private int age;
        private int sex;
        private int height;
        private int weight;
        private String remarkName;

        public Builder2(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder2 setAge(int val) {
            this.age = val;
            return this;
        }

        public Builder2 setSex(int val) {
            this.sex = val;
            return this;
        }

        public Builder2 setHeight(int val) {
            this.height = val;
            return this;
        }

        public Builder2 setWeight(int val) {
            this.weight= val;
            return this;
        }

        public Builder2 setRemarkName(String val) {
            this.remarkName = val;
            return this;
        }

        @Override
        public TestBuilder build() {
            return new TestBuilder(this);
        }
    }
}



CREATE TABLE "example_user" (
"USER_ID" VARCHAR2(50) NOT NULL,
"PASSWORD" VARCHAR2(50) NOT NULL,
PRIMARY KEY ("USER_ID")
);


COMMENT ON TABLE "example_user" IS '用户信息表';
COMMENT ON COLUMN "example_user"."USER_ID" IS '账户id';
COMMENT ON COLUMN "example_user"."PASSWORD" IS '密码';

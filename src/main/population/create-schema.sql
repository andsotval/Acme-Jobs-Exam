
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcement` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `text` varchar(255),
        `title` varchar(255),
        `url` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `application` (
       `id` integer not null,
        `version` integer not null,
        `xxxrequest_response` varchar(255),
        `creation_moment` datetime(6),
        `justification` varchar(255),
        `password` varchar(255),
        `qualifications` varchar(255),
        `reference_number` varchar(255),
        `skills` varchar(255),
        `statement` varchar(255),
        `status` integer,
        `xxx` varchar(255),
        `job_id` integer not null,
        `worker_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `firm` varchar(255),
        `responsibility` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditorrequest` (
       `id` integer not null,
        `version` integer not null,
        `firm` varchar(255),
        `responsibility` varchar(255),
        `status` bit,
        `authenticated_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditrecord` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `creation_moment` datetime(6),
        `final_mode` bit,
        `title` varchar(255),
        `auditor_id` integer not null,
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `goal_bronze` varchar(255),
        `goal_gold` varchar(255),
        `goal_silver` varchar(255),
        `reward_bronze_amount` double precision,
        `reward_bronze_currency` varchar(255),
        `reward_gold_amount` double precision,
        `reward_gold_currency` varchar(255),
        `reward_silver_amount` double precision,
        `reward_silver_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `commercial` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        `credit_cardcvv` integer,
        `credit_card_month` integer,
        `credit_card_name` varchar(255),
        `credit_card_number` varchar(255),
        `credit_card_type` varchar(255),
        `credit_card_year` integer,
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `companyrecord` (
       `id` integer not null,
        `version` integer not null,
        `ceo` varchar(255),
        `description` varchar(255),
        `email` varchar(255),
        `incorporated` bit,
        `name` varchar(255),
        `phone` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        `web` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `duty` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `percentage_of_time` double precision,
        `title` varchar(255),
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `employer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investorrecord` (
       `id` integer not null,
        `version` integer not null,
        `name` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        `statement` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `job` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `final_mode` bit,
        `more_info` varchar(255),
        `reference` varchar(255),
        `salary_amount` double precision,
        `salary_currency` varchar(255),
        `title` varchar(255),
        `employer_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `creation_moment` datetime(6),
        `tags` varchar(255),
        `title` varchar(255),
        `authenticated_id` integer not null,
        `message_thread_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `messagethread` (
       `id` integer not null,
        `version` integer not null,
        `creation_moment` datetime(6),
        `title` varchar(255),
        `owner_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `noncommercial` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        `jingle` varchar(255),
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `moment` datetime(6),
        `range_max_amount` double precision,
        `range_max_currency` varchar(255),
        `range_min_amount` double precision,
        `range_min_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `participant` (
       `id` integer not null,
        `version` integer not null,
        `messagethread_id` integer not null,
        `user_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `moment` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `spam` (
       `id` integer not null,
        `version` integer not null,
        `threshold` double precision,
        `words` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `sponsor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `organization_name` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `worker` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `qualifications` varchar(255),
        `skills` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `xxxrequest` (
       `id` integer not null,
        `version` integer not null,
        `text` varchar(255),
        `xxx` varchar(255),
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );
create index IDXnhikaa2dj3la6o2o7e9vo01y0 on `announcement` (`moment`);
create index IDX2q2747fhp099wkn3j2yt05fhs on `application` (`status`);
create index IDXarap6bcbv7ilpkjmljhng0l7i on `application` (`creation_moment` desc, `reference_number` desc, `status` asc);

    alter table `application` 
       add constraint UK_rf84q38qr35ymh5nn0dcxfdue unique (`reference_number`);

    alter table `auditorrequest` 
       add constraint UK_9sejnknunem58jlkxhyopcsy2 unique (`authenticated_id`);
create index IDXnr284tes3x8hnd3h716tmb3fr on `challenge` (`deadline`);

    alter table `companyrecord` 
       add constraint UK_ow69c893sgakbym2t21x9jrgt unique (`email`);

    alter table `companyrecord` 
       add constraint UK_7vrl4nc296g6ijlp9s5i4yg25 unique (`phone`);
create index IDXt84ibbldao4ngscmvo7ja0es on `job` (`final_mode`);

    alter table `job` 
       add constraint UK_7jmfdvs0b0jx7i33qxgv22h7b unique (`reference`);
create index IDXq2o9psuqfuqmq59f0sq57x9uf on `offer` (`deadline`);
create index IDX2jcikaiqhqcdfy62sn4d3ph58 on `offer` (`deadline`, `ticker`);

    alter table `offer` 
       add constraint UK_iex7e8fs0fh89yxpcnm1orjkm unique (`ticker`);
create index IDXlrvsw21ylkdqa1shrkwg1yssx on `request` (`deadline`);
create index IDXaprx2guy3uhcnkjql0kk9qji4 on `request` (`deadline`, `ticker`);

    alter table `request` 
       add constraint UK_9mxq3powq8tqctclj0fbi2nih unique (`ticker`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `xxxrequest` 
       add constraint UK_9d7deulgljf13sueysh436fkd unique (`job_id`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `application` 
       add constraint `FKoa6p4s2oyy7tf80xwc4r04vh6` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `application` 
       add constraint `FKmbjdoxi3o93agxosoate4sxbt` 
       foreign key (`worker_id`) 
       references `worker` (`id`);

    alter table `auditor` 
       add constraint FK_clqcq9lyspxdxcp6o4f3vkelj 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `auditorrequest` 
       add constraint `FKmj2lnje7xeeex43hlasdod3vj` 
       foreign key (`authenticated_id`) 
       references `authenticated` (`id`);

    alter table `auditrecord` 
       add constraint `FKditgyx355sc4ye86w7tj22cq6` 
       foreign key (`auditor_id`) 
       references `auditor` (`id`);

    alter table `auditrecord` 
       add constraint `FKa5p4w0gnuwmtb07juvrg8ptn6` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `commercial` 
       add constraint `FK2jw28sba4n2gi3xdkdqqhm870` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `duty` 
       add constraint `FKs2uoxh4i5ya8ptyefae60iao1` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `employer` 
       add constraint FK_na4dfobmeuxkwf6p75abmb2tr 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `job` 
       add constraint `FK3rxjf8uh6fh2u990pe8i2at0e` 
       foreign key (`employer_id`) 
       references `employer` (`id`);

    alter table `message` 
       add constraint `FK3ny0h1379q528toyokq81noiu` 
       foreign key (`authenticated_id`) 
       references `authenticated` (`id`);

    alter table `message` 
       add constraint `FKhlmmbswdtxwq1f6w6gmj14oci` 
       foreign key (`message_thread_id`) 
       references `messagethread` (`id`);

    alter table `messagethread` 
       add constraint `FK1te3egs8ru96srxjrvhcxe0fn` 
       foreign key (`owner_id`) 
       references `authenticated` (`id`);

    alter table `noncommercial` 
       add constraint `FKn6bojnyiiial7yvedm9obcdrc` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `participant` 
       add constraint `FKm83c1afcndbxya545u5op1kaj` 
       foreign key (`messagethread_id`) 
       references `messagethread` (`id`);

    alter table `participant` 
       add constraint `FK67h73ib586xy9hvw4vyy75fvv` 
       foreign key (`user_id`) 
       references `authenticated` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `sponsor` 
       add constraint FK_20xk0ev32hlg96kqynl6laie2 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `worker` 
       add constraint FK_l5q1f33vs2drypmbdhpdgwfv3 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `xxxrequest` 
       add constraint `FK4c8n1u6mr15ucy5cqqbtfc6ih` 
       foreign key (`job_id`) 
       references `job` (`id`);

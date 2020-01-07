
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `application` 
       drop 
       foreign key `FKoa6p4s2oyy7tf80xwc4r04vh6`;

    alter table `application` 
       drop 
       foreign key `FKmbjdoxi3o93agxosoate4sxbt`;

    alter table `auditor` 
       drop 
       foreign key FK_clqcq9lyspxdxcp6o4f3vkelj;

    alter table `auditorrequest` 
       drop 
       foreign key `FKmj2lnje7xeeex43hlasdod3vj`;

    alter table `auditrecord` 
       drop 
       foreign key `FKditgyx355sc4ye86w7tj22cq6`;

    alter table `auditrecord` 
       drop 
       foreign key `FKa5p4w0gnuwmtb07juvrg8ptn6`;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `commercial` 
       drop 
       foreign key `FK2jw28sba4n2gi3xdkdqqhm870`;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `duty` 
       drop 
       foreign key `FKs2uoxh4i5ya8ptyefae60iao1`;

    alter table `employer` 
       drop 
       foreign key FK_na4dfobmeuxkwf6p75abmb2tr;

    alter table `job` 
       drop 
       foreign key `FK3rxjf8uh6fh2u990pe8i2at0e`;

    alter table `message` 
       drop 
       foreign key `FK3ny0h1379q528toyokq81noiu`;

    alter table `message` 
       drop 
       foreign key `FKhlmmbswdtxwq1f6w6gmj14oci`;

    alter table `messagethread` 
       drop 
       foreign key `FK1te3egs8ru96srxjrvhcxe0fn`;

    alter table `noncommercial` 
       drop 
       foreign key `FKn6bojnyiiial7yvedm9obcdrc`;

    alter table `participant` 
       drop 
       foreign key `FKm83c1afcndbxya545u5op1kaj`;

    alter table `participant` 
       drop 
       foreign key `FK67h73ib586xy9hvw4vyy75fvv`;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `sponsor` 
       drop 
       foreign key FK_20xk0ev32hlg96kqynl6laie2;

    alter table `worker` 
       drop 
       foreign key FK_l5q1f33vs2drypmbdhpdgwfv3;

    alter table `xxxrequest` 
       drop 
       foreign key `FK4c8n1u6mr15ucy5cqqbtfc6ih`;

    drop table if exists `administrator`;

    drop table if exists `announcement`;

    drop table if exists `anonymous`;

    drop table if exists `application`;

    drop table if exists `auditor`;

    drop table if exists `auditorrequest`;

    drop table if exists `auditrecord`;

    drop table if exists `authenticated`;

    drop table if exists `challenge`;

    drop table if exists `commercial`;

    drop table if exists `companyrecord`;

    drop table if exists `consumer`;

    drop table if exists `duty`;

    drop table if exists `employer`;

    drop table if exists `investorrecord`;

    drop table if exists `job`;

    drop table if exists `message`;

    drop table if exists `messagethread`;

    drop table if exists `noncommercial`;

    drop table if exists `offer`;

    drop table if exists `participant`;

    drop table if exists `provider`;

    drop table if exists `request`;

    drop table if exists `spam`;

    drop table if exists `sponsor`;

    drop table if exists `user_account`;

    drop table if exists `worker`;

    drop table if exists `xxxrequest`;

    drop table if exists `hibernate_sequence`;

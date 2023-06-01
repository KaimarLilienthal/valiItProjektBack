INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'studio');

INSERT INTO public."user" (id, role_id, username, password, email, status) VALUES (DEFAULT, 1, 'admin', '123', 'admin@admin.eu', 'A');
INSERT INTO public."user" (id, role_id, username, password, email, status) VALUES (DEFAULT, 2, 'kaimar', '123', 'kaimar@hot.eu', 'A');
INSERT INTO public."user" (id, role_id, username, password, email, status) VALUES (DEFAULT, 2, 'liisis', '123', 'liisi@gmail.com', 'A');
INSERT INTO public."user" (id, role_id, username, password, email, status) VALUES (DEFAULT, 2, 'rain', '123', 'rain@vali.it', 'D');


INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Haabersti');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Kesklinn');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Kristiine');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Lasnamäe');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Mustamäe');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Nõmme');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Pirita');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Põhja-Tallinn');

INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'valgustus');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'mänguasjad');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'riided');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'kingad');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'ventilaator');


INSERT INTO public.customer (id, name, phone, email) VALUES (DEFAULT, 'Jyri', '53535', 'jyri@gmail.com');

INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id)
VALUES (DEFAULT, 2, 'Tulbi Ateljee', 'www.tulbi.ee', 35, 'A', null, 3, 2);

INSERT INTO public.studio_extra (id, studio_id, extra_id, price) VALUES (DEFAULT, 2, 1, 13);
INSERT INTO public.studio_extra (id, studio_id, extra_id, price) VALUES (DEFAULT, 2, 4, 12);
INSERT INTO public.studio_extra (id, studio_id, extra_id, price) VALUES (DEFAULT, 2, 5, 15);

INSERT INTO public.availability (id, studio_id, start_date, end_date, start_hour, end_hour) VALUES (DEFAULT, 2, '2023-06-01', '2023-06-11', 10, 17);






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

INSERT INTO public.studio_extra (id, studio_id, extra_id, price) VALUES (DEFAULT, 1, 1, 5);
INSERT INTO public.studio_extra (id, studio_id, extra_id, price) VALUES (DEFAULT, 1, 2, 6);
INSERT INTO public.studio_extra (id, studio_id, extra_id, price) VALUES (DEFAULT, 1, 3, 7);
INSERT INTO public.studio_extra (id, studio_id, extra_id, price) VALUES (DEFAULT, 1, 4, 8);
INSERT INTO public.studio_extra (id, studio_id, extra_id, price) VALUES (DEFAULT, 1, 5, 9);








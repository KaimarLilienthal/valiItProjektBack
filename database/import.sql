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

INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id) VALUES (DEFAULT, 2, 'Tulbi', 'www.tulbi.eu', 0, 'A', null, 1, 6);
INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id) VALUES (DEFAULT, 2, 'Karu', 'www.kati.ee', 0, 'A', null, 2, 1);
INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id) VALUES (DEFAULT, 2, 'Pilt', 'www.picture.com', 0, 'A', null, 3, 3);
INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id) VALUES (DEFAULT, 2, 'FOTOMIISU', 'www.fm.ru', 0, 'A', null, 4, 3);

INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id) VALUES (DEFAULT, 2, 'Tulbi', 'www.tulbi.eu', 0, 'A', null, 1, 6);
INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id) VALUES (DEFAULT, 2, 'Karu', 'www.kati.ee', 0, 'A', null, 2, 1);
INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id) VALUES (DEFAULT, 2, 'Pilt', 'www.picture.com', 0, 'A', null, 3, 3);
INSERT INTO public.studio (id, owner_user_id, name, url, hour_price, status, image_id, address_id, district_id) VALUES (DEFAULT, 2, 'FOTOMIISU', 'www.fm.ru', 0, 'A', null, 4, 3);





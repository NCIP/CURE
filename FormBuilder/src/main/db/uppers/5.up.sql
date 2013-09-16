---------------------------------------------------------------------------------------------------
-- Copyright (C) 2013, HealthCare IT, Inc. - All Rights Reserved-
-- Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
-- Proprietary and confidential
---------------------------------------------------------------------------------------------------

CREATE OR REPLACE VIEW "FormBuilder".fe_approved_links_count_vw AS 
 select sub1.id, COALESCE(sub2.cnt1, 0) as cnt
from (select distinct id from form_element where element_type::text <> 'link'::text) sub1
left outer join ( SELECT fe.id as id, count(fe.id) as cnt1  FROM form_element fe, form_element links, form f
		  where links.link_id = fe.uuid and f.id = links.form_id and f.status::text = 'APPROVED'::text
                  GROUP BY fe.id) sub2
on (sub1.id = sub2.id);

ALTER TABLE "FormBuilder".fe_approved_links_count_vw OWNER TO fbdev;


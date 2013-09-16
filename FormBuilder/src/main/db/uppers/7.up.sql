---------------------------------------------------------------------------------------------------
-- Copyright (C) 2013, HealthCare IT, Inc. - All Rights Reserved-
-- Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
-- Proprietary and confidential
---------------------------------------------------------------------------------------------------

-- Function: "FormBuilder".refresh_question_ts_data(integer)

-- DROP FUNCTION "FormBuilder".refresh_question_ts_data(integer);

CREATE OR REPLACE FUNCTION "FormBuilder".refresh_question_ts_data(fid integer)
  RETURNS integer AS
$BODY$
DECLARE
    q RECORD;
    a RECORD;
    av RECORD;
    data TSVECTOR;
	count INTEGER := 0;
begin

	data = ''::tsvector;
	
	FOR q IN SELECT qe.id as id, qe.short_name as short_name, fe.description as description, fe.learn_more as learn_more FROM "FormBuilder".form_element fe inner join "FormBuilder".question qe on fe.id = qe.parent_id inner join "FormBuilder".form frm on fe.form_id=frm.id WHERE fe.id = fid LOOP
		data = data ||
			setweight(to_tsvector('"FormBuilder".ts_config', coalesce(q.short_name,'')), 'A') ||
			setweight(to_tsvector('"FormBuilder".ts_config', coalesce(q.description,'')), 'B') ||
			setweight(to_tsvector('"FormBuilder".ts_config', coalesce(q.learn_more,'')), 'C');

		FOR a IN SELECT * FROM "FormBuilder".answer WHERE question_id = q.id LOOP

			data = data ||
				setweight(to_tsvector('"FormBuilder".ts_config', coalesce(a.description,'')), 'C') ||
				setweight(to_tsvector('"FormBuilder".ts_config', coalesce(a.group_name,'')), 'D');

			FOR av IN SELECT * FROM "FormBuilder".answer_value WHERE answer_id = a.id LOOP

				data = data ||
					setweight(to_tsvector('"FormBuilder".ts_config', coalesce(av.description,'')), 'C') ||
					setweight(to_tsvector('"FormBuilder".ts_config', coalesce(av.short_name,'')), 'D');
					
				count := count + 1;
	
			END LOOP;

		END LOOP;
	
	END LOOP;
	
	UPDATE "FormBuilder".form_element set ts_data = data WHERE id = fid;
	
	RETURN count;
end
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION "FormBuilder".refresh_question_ts_data(integer) OWNER TO fbdev;

select "FormBuilder".refresh_question_ts_data();

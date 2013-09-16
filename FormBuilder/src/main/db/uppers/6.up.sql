---------------------------------------------------------------------------------------------------
-- Copyright (C) 2013, HealthCare IT, Inc. - All Rights Reserved-
-- Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
-- Proprietary and confidential
---------------------------------------------------------------------------------------------------

ALTER TABLE "FormBuilder".module  ADD COLUMN uuid character(36);
UPDATE "FormBuilder".module SET uuid = (generate_uuid_v3('6ba7b8119dad11d180b400c04fd430c8', 'http://www.heathcit.com/FormBuilder/' || id))::character(36) WHERE uuid IS NULL;
ALTER TABLE "FormBuilder".module ALTER COLUMN uuid SET NOT NULL;


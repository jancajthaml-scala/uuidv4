Performant and straight-forward implementation of Universally Unique IDentifier v4 (also called guid) generator

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9d4b03d01287441ca3f21626654939ad)](https://www.codacy.com/app/jan-cajthaml/uuid?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jancajthaml-scala/uuid&amp;utm_campaign=Badge_Grade) [![Dependency Status](https://www.versioneye.com/user/projects/57dc150b037c20002d0d9b5d/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57dc150b037c20002d0d9b5d) [![Build Status](https://travis-ci.org/jancajthaml-scala/uuid.svg?branch=master)](https://travis-ci.org/jancajthaml-scala/uuid)

Exposes first class function from `import com.github.jancajthaml.uuid`, function `uuid()` generate 128bit UUID with cryptographically secure PRNG in format 8-4-4-4-12 lowercase hex digits.

* standard details http://www.ietf.org/rfc/rfc4122.txt
* entropy details https://en.wikipedia.org/wiki/Universally_unique_identifier#Random_UUID_probability_of_duplicates

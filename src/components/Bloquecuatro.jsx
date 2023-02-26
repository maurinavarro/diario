import React from 'react'

const Bloquecuatro = () => {
  return <div className='grid grid-cols-1 md:grid-cols-6'>
  {/*Barra de categoría*/}
  <div className='my-8 col-span-4'>
    <p className="mx-5 lg:mx-6 md:mx-4 2xl:mx-20"><span className="px-2 bg-[#2c9995] text-white text-center font-poppins font-semibold">POLICIALES</span></p>
    <hr className="-my-1 h-0.5 bg-[#2c9995] border-0 mx-5 md:mx-4 lg:mx-6 xl:mx-6 2xl:mx-20" />
    {/*Cards*/}
    <div className='pt-6 h-36 sm:h-52 xl:h-64'>
        <div className='mx-5 h-full flex gap-4 md:mx-4 lg:mx-6 2xl:mx-20'>
            <img src="../public/pt2-5.jpg" alt=""
            className='object-cover w-2/5' />
            <div className='w-2/3' >
            <a className='font-crimson font-semibold text-sm text-[#2c9995]' href="">Category</a>
            <h2 className='my-1 font-poppins font-semibold overflow-hidden md:text-lg xl:text-xl'>Alberto Fernández llega a Chaco</h2>
            <p className='font-crimson font-normal text-sm text-gray-400 pt-0'>Hora de publicación</p>
            </div>
        </div>
    </div>
    <div className='pt-6 h-36 sm:h-52 xl:h-64'>
        <div className='mx-5 h-full flex gap-4 md:mx-4 lg:mx-6 2xl:mx-20'>
            <img src="../public/pt2-5.jpg" alt=""
            className='object-cover w-2/5' />
            <div className='w-2/3' >
            <a className='font-crimson font-semibold text-sm text-[#2c9995]' href="">Category</a>
            <h2 className='my-1 font-poppins font-semibold overflow-hidden md:text-lg xl:text-xl'>Alberto Fernández</h2>
            <p className='font-crimson font-normal text-sm text-gray-400 pt-1'>Hora de publicación</p>
            </div>
        </div>
    </div>
    <div className='pt-6 h-36 sm:h-52 xl:h-64'>
        <div className='mx-5 h-full flex gap-4 md:mx-4 lg:mx-6 2xl:mx-20'>
            <img src="../public/pt2-5.jpg" alt=""
            className='object-cover w-2/5' />
            <div className='w-2/3' >
            <a className='font-crimson font-semibold text-sm text-[#2c9995]' href="">Category</a>
            <h2 className='my-1 font-poppins font-semibold overflow-hidden md:text-lg xl:text-xl'>Distintas actividades junto al gobernador Capitanich</h2>
            <p className='font-crimson font-normal text-sm text-gray-400 pt-1'>Hora de publicación</p>
            </div>
        </div>
    </div>
    <div className='pt-6 h-36 sm:h-52 xl:h-64'>
        <div className='mx-5 h-full flex gap-4 md:mx-4 lg:mx-6 2xl:mx-20'>
            <img src="../public/pt2-5.jpg" alt=""
            className='object-cover w-2/5' />
            <div className='w-2/3' >
            <a className='font-crimson font-semibold text-sm text-[#2c9995]' href="">Category</a>
            <h2 className='my-1 font-poppins font-semibold overflow-hidden md:text-lg xl:text-xl'>Gobernador Capitanich</h2>
            <p className='font-crimson font-normal text-sm text-gray-400 pt-1'>Hora de publicación</p>
            </div>
        </div>
    </div>
    </div>
    {/*Add Publicidad*/}
    <div className='col-span-2'>
    <img src="../public/corhaz-300.png" alt=""
     className='object-cover my-8 w-[300px] h-[250px] mx-auto md:w-[220px] md:h-[183px] md:col-span-2 lg:w-[295px] lg:h-[246px] xl:w-[300px] xl:h-[250px]' />
     <p className="mx-5 md:mx-4 lg:mx-5 xl:mx-6"><span className="px-2 bg-[#2c9995] text-white text-center font-poppins font-semibold">POLICIALES</span></p>
        <hr className="-my-1 h-0.5 bg-[#2c9995] border-0 mx-5 md:mx-4 lg:mx-6 xl:mx-6 2xl:mx-20" />
        {/*Cards*/}
        <div className='pt-6 h-36 sm:h-52 md:h-28 xl:h-36'>
        <div className='mx-5 h-full flex gap-4 md:mx-4 lg:mx-6 '>
        <div className='w-2/3 2xl:w-2/4' >
            <a className='font-crimson font-semibold text-sm xl:text-base text-[#2c9995]' href="">Category</a>
            <h2 className='my-1 font-poppins font-semibold overflow-hidden md:text-xs lg:text-sm xl:text-base'>Gobernador Capitanich</h2>
            <p className='font-crimson font-normal text-sm xl:text-base text-gray-400 pt-1'>Hora de publicación</p>
            </div>
            <img src="../public/pt2-5.jpg" alt=""
            className='object-cover w-2/5 2xl:w-40' />
        </div>
        </div>
        <div className='pt-6 h-36 sm:h-52 md:h-28 xl:h-36'>
        <div className='mx-5 h-full flex gap-4 md:mx-4 lg:mx-6 '>
        <div className='w-2/3 2xl:w-2/4' >
            <a className='font-crimson font-semibold text-sm xl:text-base text-[#2c9995]' href="">Category</a>
            <h2 className='my-1 font-poppins font-semibold overflow-hidden md:text-xs lg:text-sm xl:text-base'>Gobernador Capitanich</h2>
            <p className='font-crimson font-normal text-sm xl:text-base text-gray-400 pt-1'>Hora de publicación</p>
            </div>
            <img src="../public/pt2-5.jpg" alt=""
            className='object-cover w-2/5 2xl:w-40' />
        </div>
        </div>
        <div className='pt-6 h-36 sm:h-52 md:h-28 xl:h-36'>
        <div className='mx-5 h-full flex gap-4 md:mx-4 lg:mx-6 '>
        <div className='w-2/3 2xl:w-2/4' >
            <a className='font-crimson font-semibold text-sm xl:text-base text-[#2c9995]' href="">Category</a>
            <h2 className='my-1 font-poppins font-semibold overflow-hidden md:text-xs lg:text-sm xl:text-base'>Gobernador Capitanich</h2>
            <p className='font-crimson font-normal text-sm xl:text-base text-gray-400 pt-1'>Hora de publicación</p>
            </div>
            <img src="../public/pt2-5.jpg" alt=""
            className='object-cover w-2/5 2xl:w-40' />
        </div>
        </div>

    <img src="../public/corhaz-300.png" alt=""
     className='object-cover my-8 w-[300px] h-[250px] mx-auto md:w-[220px] md:h-[183px] md:col-span-2 lg:w-[295px] lg:h-[246px] xl:w-[300px] xl:h-[250px]' />
     </div>
  </div>;
  };

export default Bloquecuatro;